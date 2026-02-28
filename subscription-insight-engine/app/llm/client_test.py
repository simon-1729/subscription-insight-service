from openai import AsyncOpenAI
import os
import asyncio

async def openai_client_test():
    client = AsyncOpenAI(api_key=os.getenv("OPENAI_API_KEY"))

    response = await client.chat.completions.create(
        model="gpt-5-nano",
        service_tier="flex",
        messages=[
            {"role": "system", "content": "You are helpful."},
            {"role": "user", "content": "Say hello and tell me what model version you are."}
        ],
    )

    return response.choices[0].message.content
