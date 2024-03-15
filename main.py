from fastapi import FastAPI
from http.client import HTTPException
import httpx

app = FastAPI()

@app.get("/despesas/tipo-transferencia")
async def get_tipo_transferencia():
    url = "https://api.portaldatransparencia.gov.br/api-de-dados/despesas/por-orgao"
    
    # Header
    headers = {
        "User-Agent": "Seu Agente de Usuário",
        "Authorization": "Bearer Seu_Token" 
    }

    # Retrieve
    async with httpx.AsyncClient() as client:
        response = await client.get(url, headers=headers)

        if response.status_code == 200:
            return response.json()
        else:
            raise HTTPException(status_code=response.status_code, detail="Fail")
