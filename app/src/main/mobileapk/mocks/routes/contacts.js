// Use this file only as a guide for first steps. Delete it when you have added your own routes files.
// For a detailed explanation regarding each routes property, visit:
// https://mocks-server.org/docs/get-started-routes

// users data
const USERS = [
  {
    id: 1,
    firstName: "Juan",
    lastName: "Pérez",
    gender: "M"
  },
  {
    id: 2,
    firstName: "Martín",
    lastName: "Cárcamo",
    gender: "M"
  },
  {
    id: 3,
    firstName: "Flora",
    lastName: "Rosales",
    gender: "F"
  },
  {
    id: 4,
    firstName: "Jacinta",
    lastName: "Torres",
    gender: "F"
  },
  {
    id: 5,
    firstName: "Soledad",
    lastName: "Palma",
    gender:"F"
  },
  {
    id: 6,
    firstName: "José",
    lastName: "Antúnez",
    gender: "M"
  },

];

module.exports = [
  {
    id: "get-contacts", // id of the route
    url: "/api/contacts", // url in express format
    method: "GET", // HTTP method
    variants: [
      {
        id: "success", // id of the variant
        response: {
          status: 200, // status to send
          body: USERS, // body to send
        },
      },
      {
        id: "error", // id of the variant
        response: {
          status: 400, // status to send
          body: {
            // body to send
            message: "Error",
          },
        },
      },
    ],
  },
  {
    id: "get-contact", // id of the route
    url: "/api/contact/:id", // url in express format
    method: "GET", // HTTP method
    variants: [
      {
        id: "success", // id of the variant
        response: (req, res) => {
          const userId = req.params.id;
          const user = USERS.find((userData) => userData.id === Number(userId));
          if (user) {
            res.status(200);
            res.send(user);
          } else {
            res.status(404);
            res.send({
              message: "User not found",
            });
          }
        },
      },
    ],
  },
];
