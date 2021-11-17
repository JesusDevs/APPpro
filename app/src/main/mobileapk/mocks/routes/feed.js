const POSTS = [
    {
        id : 1,
        "title": "Juan se fue de vacaciones!!",
        "image": "https:\/\/live.staticflickr.com\/7294\/8715121895_70db52b260_m.jpg",
        "date": "2013-05-03T13:10:45-08:00",
        "description": "Juan nos va ilustrar acerca de las historias de su viaje por el sudeste asáitico, en una hermosa jornada de cuentos. ",
        "published": "2013-05-07T00:14:01Z",
        "author_id": "1",
   },
   {
        id : 2,
        "title": "Recomendaciones generales de Segurito: #10 Cuidemos a nuestros Recolectores de residuos",
        "image": "https:\/\/live.staticflickr.com\/6045\/6315859408_95d6d00104_m.jpg",
        "date": "2011-11-05T12:41:48-08:00",
        "description": "<p>En este episodio Segurito descubre que Abel está subiendo videos antivacunas a la web, dónde indica que al vacunarse se podría volver magnético, receptor de señales de 5g con un chip y hasta que la tierra es plana... Puras mentiras del pobre Abel para hacerse famoso como youtuber, afortunadamente su pediatra lo desmiente y lo hace recapacitar!</p>",
        "published": "2011-11-05T18:41:48Z",
        "author_id": "3",

   },
   {
        id : 3,
        "title": "BENEFICIO CINEMARK JUEVES A DOMINGO CAJA LOS ANDES",
        "image": "https:\/\/live.staticflickr.com\/6103\/6315343369_b50735c0da_m.jpg",
        "date": "2011-11-05T12:41:47-08:00",
        "description": " <p><strong>Cinemark</strong></p><p><strong>$2.950</strong></p><ul><li>En ticket para película 2D de jueves a domingo:<br>&nbsp;</li><li>En ticket para película 2D de jueves a domingo y valores especiales<br>&nbsp;</li><li><strong>$2.950 valor ticket</strong> para película 2D.</li><li><strong>$3.350valor ticket</strong> para película 2D sala XD.</li><li><strong>$5.500valor ticket</strong> para butacas DBOX 2D.</li><li><strong>$3.800valor ticket</strong> para butaca Palco Premier.</li></ul><p>&nbsp;</p><p>https://masbeneficios.cajalosandes.cl/tiempo-libre-convenio?beneficio=cinemark-desc-2950</p>",
        "published": "2011-11-05T18:41:47Z",
        "author_id": "2",
   },
   {
        id : 4,
        "title": "Cuidar el medio ambiente en la oficina",
        "link": "https:\/\/www.flickr.com\/photos\/joestump\/6315859322\/",
        "image": "https:\/\/live.staticflickr.com\/6113\/6315859322_402192d4a1_m.jpg",
        "date": "2011-11-05T12:41:46-08:00",
        "description": " <p>Equipo!&nbsp;</p><p>En este epoca donde hay mucha sequía y el cambio climático está comenzando a afectarnos, es importante que sepamos como cuidar nuestro planeta desde nuestra oficina.&nbsp;</p><p>Les adjunto buenas practicas que todos podemos aplicar en nuestro día día.</p><p>Saludos!</p>",
        "published": "2011-11-05T18:41:46Z",
        "author_id": "2",
   },
   {
        id : 5,
        "title": "BENEFICIOS  FAMARCIAS CAJA LOS ANDES",
        "image": "https:\/\/live.staticflickr.com\/6093\/6315859272_a1a0a3c5da_m.jpg",
        "date": "2011-11-05T12:41:45-08:00",
        "description": "<p>Estimad@s:</p><p>Les dejo información de beneficios de caja los andes y dejo el Link de la página de la caja para que puedan revisar esto con mayor detalles.</p><p><a href=\"https://masbeneficios.cajalosandes.cl/\">https://masbeneficios.cajalosandes.cl/</a></p><p><br>&nbsp;</p>",
        "published": "2011-11-05T18:41:45Z",
        
        "author_id": "4",

   },
   {
        id : 6,
        "title": "QUEDAN 03 DIAS - FIESTAS PATRIAS 2021",
        "image": "https:\/\/live.staticflickr.com\/6092\/6315343227_28095446b4_m.jpg",
        "date": "2011-11-05T12:41:44-08:00",
        "description": " <p><i><strong>¡Tikitikiti Tikitikita Llegó el Momento de Concursar!</strong></i></p><p>Recuerda puedes enviar tus registros para concursar en las diferentes categorías hasta el <strong>Miércoles 15 de Septiembre!</strong>!</p><p>&nbsp;</p><p>La ceremonia de premiaron se realizará el día <i><strong>Jueves 16 de Septiembre a las 09:30 am.</strong></i></p><p>&nbsp;</p><p><i><strong>TE ADJUNTAMOS LAS BASES OFICIALES !!!!</strong></i></p><p>&nbsp;</p><p>Anímate yparticipa en estas fiestas patrias año 2021 junto a tu familia 👪🐎🍷</p>",
        "published": "2011-11-05T18:41:44Z",
        
        "author_id": "1",

   }
  
  ];
  
  module.exports = [
    {
      id: "get-feed", // id of the route
      url: "/api/feed", // url in express format
      method: "GET", // HTTP method
      variants: [
        {
          id: "success", // id of the variant
          response: {
            status: 200, // status to send
            body: POSTS, // body to send
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
      id: "get-post", // id of the route
      url: "/api/post/:id", // url in express format
      method: "GET", // HTTP method
      variants: [
        {
          id: "success", // id of the variant
          response: (req, res) => {
            const postId = req.params.id;
            const post = POSTS.find((postData) => postData.id === Number(postId));
            if (post) {
              res.status(200);
              res.send(post);
            } else {
              res.status(404);
              res.send({
                message: "post not found",
              });
            }
          },
        },
      ],
    },
  ];
  