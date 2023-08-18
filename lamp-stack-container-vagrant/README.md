# DevOps-EDegree
Devops Projects

As part of my DevOps training, I was asked to carry out various projects described below:

# Topic : implement a lamp stack container with vagrant

To implement a LAMP (Linux, Apache, MySQL, PHP) stack container using Vagrant, you can follow these steps:

1. Install Vagrant and VirtualBox:
   - Download and install VirtualBox from the official website (https://www.virtualbox.org).
   - Download and install Vagrant from the official website (https://www.vagrantup.com).
   - Docker also must be installed on your system before running this Vagrantfile.
2. Initialize a new Vagrant environment by running the following command:
```csharp
 vagrant init
```
3. Open the generated Vagrantfile with a text editor and replace its contents with the following configuration:

```ruby
Vagrant.configure("2") do |config|
  config.vm.box = "generic/ubuntu2010"

    config.vm.define "web" do |web|
      web.vm.hostname = "web"
      web.vm.network "private_network", ip: "192.168.56.2"
      web.vm.synced_folder ".", "/vagrant-data"

      web.vm.provider "docker" do |docker|
        docker.image = "php:7.4-apache"
        docker.ports = ["80:80"]
        docker.volumes = ["./html:/var/www/html"]  
    end  
  end

  config.vm.define "db" do |db|
    db.vm.hostname = "db"
    db.vm.network "private_network", ip: "192.168.56.8"
    db.vm.synced_folder ".", "/vagrant-data"

    db.vm.provider "docker" do |docker|
      docker.image = "mariadb:latest"
      docker.ports = ["3306:3306"]
      docker.environment = {
        MYSQL_ROOT_PASSWORD: "toor",
        MYSQL_DATABASE: "app_user",
        MYSQL_USER: "db_user",
        MYSQL_PASSWORD: "app_user"
      }
      docker.volumes = ["./mysql:/var/lib/mysql"]
    end
  end

end

```
4. Create a directory named "html" in the same location as the Vagrantfile. This directory will be shared with the Docker container.
In this configuration, we have defined two containers: **web** and **db**. The web container uses the **php:7.4-apache** image and maps port 80 of the container to port 80 of the host machine. It also mounts the ./html directory as the document root for Apache.

The db container uses the **mariadb:latest** image and maps port 3306 of the container to port 3306 of the host machine. It sets up the necessary environment variables for MySQL, including the root password, database name, username, and password. It also mounts the ./mysql directory as the data directory for MySQL.

5. Start the Vagrant VM:
   - Open a command prompt or terminal and navigate to the directory containing the Vagrantfile.
   - Run the command `vagrant up --provider=docker` to start the Vagrant VM and provision it with the LAMP stack components.
   - Vagrant will pull the necessary Docker image and start the container based on the provided configuration.
   - Wait for the VM to be created and provisioned. This may take a few minutes.

6. Access the LAMP stack container:
   - Once the Vagrant machine is up and running, you can access the LAMP stack by opening a web browser and navigating to  `http://192.168.56.2`. The web server running in the Docker container will serve the content from the html directory.
   - To access the MySQL server, you can use the `mysql` command-line tool from within the VM.

By following these steps, we can create a LAMP stack VM using Vagrant. Vagrant will provision the containers and set up the LAMP stack for you.