# teste
teste da pismo

no diretório raiz executar os seguintes passos

mvn clean package

sudo docker-compose -f stack.yml build

sudo docker-compose -f stack.yml up -d

# INSERIR ACCOUNT

POST localhost:8080/accounts/
body request:
{
    "documentNumber":"12345678900"
}

# CONSULTAR ACCOUNT

GET localhost:8080/accounts/{id}
body response:
{
    "accountId": 1,
    "documentNumber": 12345678900
}

# INSERIR TRANSACTION

POST localhost:8080/transactions
body request:
{
    "account":{
        "accountId":1
    },
    "operationType":{
        "id":4
    },
    "amount": 500
}
