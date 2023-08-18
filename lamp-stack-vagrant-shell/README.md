# DevOps-EDegree
Devops Projects

As part of my DevOps training, I was asked to carry out various projects described below:

# Topic : implement a lamp stack with vagrant

To implement a LAMP (Linux, Apache, MySQL, PHP) stack container using Vagrant, you can follow these steps:

1. Install Vagrant and VirtualBox:
   - Download and install VirtualBox from the official website (https://www.virtualbox.org).
   - Download and install Vagrant from the official website (https://www.vagrantup.com).

2. Create a Vagrantfile:
   - Open a text editor and create a new file named "Vagrantfile" in an empty directory.
   - Add the following configuration to the Vagrantfile:

```ruby
Vagrant.configure("2") do |config|
  config.vm.define "lampstack" do |lampstack|
    lampstack.vm.hostname = "lampstack"
    lampstack.vm.box = "bento/centos-7.4"
    lampstack.vm.network "private_network", ip: "192.168.56.2"
    lampstack.vm.synced_folder ".", "/vagrant-data"
    config.vm.provision "shell", inline: <<-SHELL
    yum -y update
    yum -y install httpd
    systemctl start httpd
    systemctl enable httpd
    yum -y install mariadb-server
    systemctl start mariadb
    systemctl enable mariadb

    yum -y install php php-mysql
    systemctl restart httpd
    echo "<h1> Hello World from  $(hostname -f)</h1>" > /var/www/html/index.php
  SHELL
  end
end
```

3. Start the Vagrant VM:
   - Open a command prompt or terminal and navigate to the directory containing the Vagrantfile.
   - Run the command `vagrant up` to start the Vagrant VM and provision it with the LAMP stack components.
   - Wait for the VM to be created and provisioned. This may take a few minutes.

4. Access the LAMP stack container:
   - Once the VM is up and running, you can access the LAMP stack container by running `vagrant ssh` to log into the VM.
   - You will be logged in as the `vagrant` user. To access the Apache web server, open a web browser on your host machine and visit `http://192.168.56.2`.
   - To access the MySQL server, you can use the `mysql` command-line tool from within the VM.

By following these steps, we can create a LAMP stack VM using Vagrant. The Vagrantfile provisions a CentOs VM, installs Apache, MySQL, PHP, and necessary modules/packages, and starts the Apache web server. However we can customize the Vagrantfile and provision additional configurations as per your requirements.