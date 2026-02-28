import asyncio
from fastapi import FastAPI, HTTPException
from fastapi.concurrency import asynccontextmanager

from app.llm.client_test import openai_client_test
from app.messaging.kafka.consumer import KafkaConsumerService
from app.config.settings import settings

app = FastAPI()

consumer = KafkaConsumerService(
    topic=settings.kafka_usage_topic,
    bootstrap_servers=settings.kafka_bootstrap_servers,
    group_id=settings.kafka_group_id
)

@asynccontextmanager
async def lifespan(app: FastAPI):
    await consumer.start()

    async def handler(event):
        print("Received event:", event)

    task = asyncio.create_task(consumer.listen(handler))

    try:
        yield   # ← App runs while paused here
    finally:
        task.cancel()
        await consumer.stop()

app = FastAPI(lifespan=lifespan)


@app.get("/")
def read_root():
    return {"message": "AI Subscription Insight Engine Running..."}

@app.get("/llm-test")
async def llm_test():
    try:
        result = await openai_client_test()
        return {"response": result}
    except Exception as e:
        print("LLM test failed", e)
        raise HTTPException(
            status_code=500,
            detail="LLM test failed. Check logs for details."
        )