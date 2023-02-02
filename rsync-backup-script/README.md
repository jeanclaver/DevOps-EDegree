# Projet 1:
TOPIC: Backup Scheme (Make a local backup scheme using rsync . You can try to compress it and schedule it using crontab. Please upload your code in dropbox/ Gdrive or github and share the link below for us to check it. You will be graded based on quality of your implementation. )

# Problem 
How to Back Up and Restore Your Linux System Using the Rsync Utility ?
What is the your ability to recover when  a system failure, a natural disaster, or a malware attack happens ?

Server backups provide the much-needed confidence that data is not lost and can be recovered in case of any eventuality. We have differents OS and each of them expose different ways to handle Server backups.
Here we are going to see how we can use Linux OS which offers different tools to see how we can backup our server.
Backing up your server is also import like taking care of your child everyday. As Linux users different backup solutions are available. We can  use backup software like NetBckup that automatically backs up your system at predefined times. Alternatively, you could manually back up your server to an external hard drive, RAID array, or another remote server. One of the handiest and reliable backup tools you can use to back up your server is : rsync.

# What Is the Rsync Tool?
rsync: Synchronize files for backup

The rsync command was written by Andrew Tridgell and Paul Mackerras and first released in 1996. The primary intention for rsync is to remotely synchronize the files on one computer with those on another.

sync is a fairly simple to use yet very powerful program. It allows you to perform synchronization between two directories, whether on the same PC or between two computers connected in a network.

Backing up data is something that most sysadmins need to do regularly. Specially for this topic , we are going to create two Virtual machine using Vagrant and Qemu.

In the first machine we will write Two  scripts for an incremental backups with rsync. The first script is for a local backup as we can see in the figure 1 (rync.png) below and the second one is for remote backup from machine 1 to machine 2 as described in the figure 2 (rync1.png) below.
![rsync](https://user-images.githubusercontent.com/71864195/216413139-f6a27a5f-ac3b-41b1-9014-17cbf72a0d4d.png)
figure 1 (rync.png)
![rsync1](https://user-images.githubusercontent.com/71864195/216413232-8cfe207b-c3bf-4634-b80d-6eb1b135e700.png)

 figure 2 (rync1.png)

To get rsync working between two hosts, the rsync program must be installed on both the source and destination, and you’ll need a way to access one machine from the other. The easiest way to transfer files is to use a remote shell account, and we’ll assume that you want to transfer files using SSH access. However,remember that rsync can be handy even for copying files and directories between locations on a singlebmachine, such as from one filesystem to another.

# Save to another folder on the same computer

In the examples that follow, I'm going to assume that you want to back up the home directory folder to a backups folder.

To create the first the script please just run the commande vagrant up to emulate the VMs. Then run vagrant ssh devbox to login.
Now execute incremental-backups-with-rsync.sh on the machine 1 with IP 192.168.122.231.


So this script is going to create incremental backups of our $HOME directory. Let have a look on the variables.  
SOURCE_DIR: which contains the absolute path of the directory we want to backup (our home directory in this case).  
BACKUP_DIR: directory which contains the path to the directory where all the backups will be stored.  
DATETIME: which stores the current timestamp.  
BACKUP_PATH: which is the absolute path of the backup directory obtained by ‘joining’ BACKUP_DIR and the current DATETIME.  
LATEST_LINK: variable which contains the path of the symbolic link which will always point to the latest backup.  


We then launch the rsync command providing the -a option (short for --archive) to preserve the most important attributes of the source files, the -v option to make the command more verbose (optional), and the --delete option to make so that files deleted from source are also deleted on destination.

To compress data during transfer, use the -z switch with your rsync command.

After that we need to create a cronjob to execute the script by executing the following commands.  

# Backup to another computer

Now let's look at backing up to another computer, because that's fine, but you'd feel safer if the files were sent somewhere else, on another computer which called "backupserver" as mentionned in our Vagrantfile.
The advantage of rsync is that it can copy files using several different methods. The most commonly used, which we will choose here, is to go through SSH. As you can see, SSH is used to secure all types of transfers.
After login in our devbox machine, we can execute incremental-remotebackups-with-rsync.sh

So this script is going to create incremental backups of our $HOME directory. Let have a look on the variables.  
SOURCE_DIR: which contains the absolute path of the directory we want to backup (our home directory in this case).  
BACKUP_DIR: directory which contains the path to the directory where all the backups will be stored.  
DATETIME: which stores the current timestamp.  
BACKUP_PATH: which is the absolute path of the backup directory obtained by ‘joining’ BACKUP_DIR and the current DATETIME.  
LATEST_LINK: variable which contains the path of the symbolic link which will always point to the latest backup.
DEST_IP: it the IP adress of our  "backupserver" machine. 

To compress data during transfer, use the -z switch with your rsync command in .sh file.


# Scheduling the Backup
Here comes crontab. we want our backups to be automated. Cron utility that allows automating tasks at a specific period. Cron is an effective and popular command-line utility used to schedule a broad range of tasks at a specified time without user interaction.

#### $ crontab -e
Then add the line below to tell the script to be executed every 10 hours.  

#### 0 */10 * * * /home/vagrant/backupshellscript/incremental-backups-with-rsync.sh  
*/10 is the hour position of the crontab syntax  
/10 specifies to execute the backup every 10 hours. If */10 is written in the minutes position, it will execute every 10 minutes.  

To implement the remote backup let execute incremental-remotebackups-with-rsync.sh  on the machine 1  


This script will backup the home directory of machine 1 toward the machine 2. Let create a cronjob and add the line below to execute the script every 11 hours  .
#### 0 */11 * * * /home/vagrant/backupshellscript/incremental-remotebackups-with-rsync.sh    

Note : You should create  a passwordless connection between machine 1 and machine2 then make sure that rsync is running on both machines.  

All human work is perfectible at will. Do not hesitate to share your suggestions with me in order to improve this script further.

Thanks
