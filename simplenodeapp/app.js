const express = require('express');
const app = express();
const port = 3000;
// Define a route to handle GET requests to the root URL
app.get('/', (req, res) => {
  res.send('Hello everyone! This is a simple NodeJs application');
}
);

// Start the server
 app.listen(port, () => {
   console.log(`Server running on port ${port}`);
 }
);
