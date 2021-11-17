module.exports = [
    {
      id: "login", // id of the route
      url: "/api/login", // url in express format
      method: "POST", // HTTP method
      variants: [
        {
          id: "success", // id of the variant

          response: (req, res) => {
            const user = req.body.username;
            const password = req.body.password;
            if (user=="juan@empresa.cl" && password=="mi_password") {

                res.status(200); // status to send
                res.headers = {"content-type": "application/json"};
                res.send("{ \"STATUS\": \"OK\", \"api-token\": \"a88cfc8ea5ca5a47f27a5320c23db568\"}");

            } else {

                res.status(400); // status to send
                res.headers = {"content-type": "application/json"};
                res.send("{ \"STATUS\": \"ERROR\", \"message\": \"Invalid credentials\"}");

            }
          }
        },
      ],
    }
];