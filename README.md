# track-api

## User Register

### Request
**URL:**
``` http://localhost:8080/users/register```
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

### Response
```json
{
    "status": "OK",
    "jwtToken": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJjZW1iZXJrZTYxIiwiYXV0aCI6W3siYXV0aG9yaXR5IjoiUk9MRV9DTElFTlQifV0sImlhdCI6MTU4NTU4NDkyMiwiZXhwIjoxNTg1NTg1MjIyfQ.BJ-nN6TXfvSn5ip4fY8HjfYGU-LJmIHI4X84mkd38yY"
}
```

## User Login

### Request
**URL:**
``` http://localhost:8080/users/login```
```json
{
	"email": "cemberkecebi@gmail.com",
	"password": "123456"
}
```

### Response
```json
{
    "status": "OK",
    "jwtToken": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJjZW1iZXJrZWNlYmlAZ21haWwuY29tIiwiYXV0aCI6W3siYXV0aG9yaXR5IjoiUk9MRV9DTElFTlQifV0sImlhdCI6MTU4NTY2Njc2NiwiZXhwIjoxNTg1NjY3MDY2fQ.c6DIP6Q1gxFL8P_z5j1YxDvwyzYQNGOSmUes9uF997w"
}
```





