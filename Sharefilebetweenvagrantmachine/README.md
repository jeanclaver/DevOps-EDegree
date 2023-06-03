# DevOps-EDegree
Devops Projects

As part of my DevOps training, I was asked to carry out various projects described below:

# Topic :  Share file between vagrant machine - Create a moderate size file named "Donotshare" and share it between two vagrant machines.

To share a file between two Vagrant machines, you can follow these steps:

1- Create the file "Vagrantfile" in the directory of the project.

- To begin, open the project folder in your terminal, then run the **"vagrant init"**command. This command will create the Vagrantfile. 
- In this file, we will declare our different machines. For this project, we're going to create two virtual machines: **"chef"** and **"devbox"**. You can take a look at our Vagrantfile for more details on configuring these machines.

2- In your Vagrantfile, configure the shared folder by adding the following line to the configuration block for each Vagrant machine:

**chef.vm.synced_folder ".", "/vagrant-data"**
- This line tells us that the root folder where the Vagrantfile is located is synchronised with the virtual machines via the **"/vagrant-data"** folder.  
- The shared folder should now be accessible from both Vagrant machines under the **"/vagrant-data"** directory.


3- Save the Vagrantfile and run the **vagrant up** command to start the two Vagrant machines.

4- SSH into the first Vagrant machine by running **"vagrant ssh chef"** in your terminal.

5- Inside the first Vagrant machine, access the shared folder by running cd /vagrant-data.

6 -However, if you create the "Donotshare" file with the desired content by running **"touch Donotshare"** to create an empty file or by using a text editor to add content.

7- Exit the SSH session on the first Vagrant machine by running exit.

8- Connect via SSH to the second Vagrant machine by running **"vagrant ssh devbox"** in your terminal.

9- Inside the second Vagrant machine, access the shared folder by running **"cd /vagrant-data"**.

10- Check that the file "Donotshare" is accessible in the second Vagrant machine by running **ls** to display the list of files in the shared folder.

Now, the "Donotshare" file should be accessible from both Vagrant machines in the **"/vagrant-data"** directory. You can read, modify, or delete the file as needed. Remember to adjust the file path and names to match your specific setup.
Any changes made to the file in one machine will also be visible in the other machine.

