# track-api

## User Register

### Request

```http://localhost:8080/users/register Request```
```json
{
	"name": "cem",
	"surname": "cebi",
	"username" : "cemberke61",
	"email" : "cemberkecebi@gmail.com",
	"password": "123456",
	"gsmNumber": "05012093961"
}
```
```http://localhost:8080/users/register Response```

### Response
```json
{
    "status": "OK",
    "jwtToken": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJjZW1iZXJrZTYxIiwiYXV0aCI6W3siYXV0aG9yaXR5IjoiUk9MRV9DTElFTlQifV0sImlhdCI6MTU4NTU4NDkyMiwiZXhwIjoxNTg1NTg1MjIyfQ.BJ-nN6TXfvSn5ip4fY8HjfYGU-LJmIHI4X84mkd38yY"
}
```






