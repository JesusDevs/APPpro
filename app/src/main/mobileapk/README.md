# mobile-test-mock-api

This server-side mocked API is intended to help you creating a mobile App that implements
the basics of an enterprise content app

# Quickstart

### install dependencies

`npm install`

### run mocked server

`npm run mocks`

# Available endpoints:


### Login
`/api/login`

You should authenticate before using the API.

Send a POST, sending `{"username": <username>, "password": <password>}`

### Feed posts
`/api/feed`

The content feed for the app's home page

### Contacts
`/api/contacts`

The contact list that you sould show, including all your co-workers

### Add a post to the favorites
`/api/favorite`

Adds a post to your favorites.

Headers:
    You must include the `apikey` in the headers:

`apikey: <the api key that you got on the login service>`

Payload:
    Include the `postid` in the body:

`{"postid": <id of the post to add to your favorites>}`
        
