# Subscription Insight Engine

#### AI-powered decision support service that analyzes customer subscription behaviour and generates risk insights such as churn probability, usage anomalies, and retention recommendations.

#### This service is part of a distributed microservices platform that uses event-driven architecture to process subscription usage events and produce AI-driven insights.

---
### Tech Stack:
#### uvicorn - ASGI (Asynchronous Server Gateway Interface)
#### FastAPI - Web Framework
#### Pydantic - REST Validation, DTO json mapping.


---
Requires Python 3.11+
###  Create virtual environment
````bash

python -m venv venv
````

###  Activate virtual environment (mac)
````bash
source venv/bin/activate
````

###  Install dependencies
````bash
pip install -r requirements.txt
````

###  Export "your" API key for OpenAI
<span style="color:red">For example</span>

````bash
export OPENAI_API_KEY="si4-proj-_cv55Nk77IB87iMGQ7eTqcVue2MB3eVewMH-oNgxyfUIPdDvz7jTGT3BlbkFJ9okUCzS9_LLA9Ngjf-8LZRj6dIgAx_htCxXXrX4XXX67d4Xop1oPntt6HllRZb1uC-EyCdqWa-J3WgF3sQxKIA"
````

###  Run the application
````bash
uvicorn app.main:app --reload
````

### Check service is up!
http://localhost:8000/docs

### Check OpenAI integration
http://localhost:8000/llm-test