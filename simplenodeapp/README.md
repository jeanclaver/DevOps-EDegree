# DevOps-EDegree
Devops Projects

As part of my DevOps training, I was asked to carry out various projects described below:

# Topic :  Run a simple node app which can be accessed through browser

To run a simple Node.js app that can be accessed through a browser, you can follow these steps:

1. Create a new directory for your Node.js app and navigate into it:
   ```shell
   'mkdir simplenodeapp'
   'cd simplenodeapp'
   ```

2. Initialize a new Node.js project by running the following command and following the prompts:
   ```shell
   'npm init'
   ```

3. Install the Express framework, which will help you create a web server:
   ```shell
   'npm install express'
   ```

4. Create a new file named `app.js` and open it in a text editor.

5. In `app.js`, add the following code to set up a basic web server using Express:

   ```javascript
   const express = require('express');
   const app = express();
   const port = 3000;

   // Define a route to handle GET requests to the root URL
   app.get('/', (req, res) => {
     res.send('Hello everyone! This is a simple NodeJs application!');
   });

   // Start the server
   app.listen(port, () => {
     console.log(`Server running on port ${port}`);
   });
   ```

   This code sets up a simple Express server that listens on port 3000 and responds with "Hello, world!" when a GET request is made to the root URL ("/").

6. Save the `app.js` file.

7. In the command line, run the following command to start the Node.js app:
   ```shell
   'node app.js'
   ```

8. Open a web browser and navigate to `http://192.168.56.61:3000`. You should see the message "Hello everyone! This is a simple NodeJs application!" displayed in the browser.

