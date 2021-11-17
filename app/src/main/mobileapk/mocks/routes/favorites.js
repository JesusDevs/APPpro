module.exports = [
    {
      id: "favorites", // id of the route
      url: "/api/favorite", // url in express format
      method: "POST", // HTTP method
      variants: [
        {
          id: "success", // id of the variant

          response: (req, res) => {
            const apikey = req.headers["apikey"];
            const postid = req.body.postid;
            if (apikey == "a88cfc8ea5ca5a47f27a5320c23db568" && postid) {

                res.status(200); // status to send
                res.headers = {"content-type": "application/json"};
                res.send("{ \"STATUS\": \"OK\"}");

            } else {

                res.status(400); // status to send
                res.headers = {"content-type": "application/json"};
                res.send("{ \"STATUS\": \"ERROR\", \"message\": \"Invalid apikey or post_id\"}");

            }
          }
        },
      ],
    }
];