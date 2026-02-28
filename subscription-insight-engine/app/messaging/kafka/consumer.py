import json
from aiokafka import AIOKafkaConsumer

class KafkaConsumerService:

    def __init__(self, topic: str, bootstrap_servers: str, group_id: str):
        self.consumer = AIOKafkaConsumer(
            topic,
            bootstrap_servers=bootstrap_servers,
            group_id=group_id,
            auto_offset_reset="earliest",
            value_deserializer=lambda v: json.loads(v.decode("utf-8"))
        )

    async def start(self):       
        await self.consumer.start()

    async def stop(self):
        await self.consumer.stop()

    async def listen(self, handler):
        async for msg in self.consumer:
            await handler(msg.value)