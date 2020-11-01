# fastAPI

> 使用fastAPI过程中的记录

[TOC]

## Installation

通过使用 **pip** 来安装

```shell
$ pip install fastapi
```

同时，我们还需要一个ASGI服务

```shell
$ pip install uvicorn
```

## Example

 - Create a file `main.py` with:

   ```python
   from typing import Optional
   from fastapi import FastAPI
   
   app = FastAPI()
   
   @app.get("/")
   def read_root():
       return {"Hello": "World"}
   
   
   @app.get("/items/{item_id}")
   def read_item(item_id: int, q: Optional[str] = None):
       return {"item_id": item_id, "q": q}
   ```

   

 - Run th server with:

   ```shell
   $ uvicorn main:app --reload
   
   INFO:     Uvicorn running on http://127.0.0.1:8000 (Press CTRL+C to quit)
   INFO:     Started reloader process [28720]
   INFO:     Started server process [28722]
   INFO:     Waiting for application startup.
   INFO:     Application startup complete.
   ```

   

