# track-api

[![Build Status](https://travis-ci.com/cemthecebi/track-api.svg?token=888a1otqj2xSp8fCqbwp&branch=master)](https://travis-ci.com/cemthecebi/track-api)

## User Register

### POST Request
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

### POST Request
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
## Retrieve Categories

### GET Request
**URL:**
``` http://localhost:8080/category/all```

### Response
```json
{
    "status": "OK",
    "categoryVoList": [
        {
            "name": "Action",
            "description": "Best Action Tv Series"
        },
        {
            "name": "Romance",
            "description": "Best Romance Tv Series"
        },
        {
            "name": "Sci-fi",
            "description": "Best Sci-fi Tv Series"
        },
        {
            "name": "Horror",
            "description": "Best Horror Tv Series"
        },
        {
            "name": "Fantasy",
            "description": "Best Fantasy Tv Series"
        }
    ]
}
```

## Retrieve Movies For HomePage

### GET Request
**URL:**
``` http://localhost:8080/tvshow/all```

### Responsee
```json
{
    "status": "OK",
    "homePageTvShowVoList": [
        {
            "imageLink": "https://m.media-amazon.com/images/M/MV5BYTRiNDQwYzAtMzVlZS00NTI5LWJjYjUtMzkwNTUzMWMxZTllXkEyXkFqcGdeQXVyNDIzMzcwNjc@._V1_SY1000_CR0,0,734,1000_AL_.jpg",
            "title": "Game of Thrones"
        },
        {
            "imageLink": "https://m.media-amazon.com/images/M/MV5BMTEyODg2NzkwMDBeQTJeQWpwZ15BbWU4MDQwODI3MzIx._V1_.jpg",
            "title": "Sons of Anarchy"
        },
        {
            "imageLink": "https://m.media-amazon.com/images/M/MV5BMTM5MjkwMTI0MV5BMl5BanBnXkFtZTcwODQwMTc0OQ@@._V1_.jpg",
            "title": "Dexter"
        }
    ]
}
```




