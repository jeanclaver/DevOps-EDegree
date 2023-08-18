# DevOps-EDegree
Devops Projects

As part of my DevOps training, I was asked to carry out various projects described below:

# Topic :  Deploy Web Application using Ansible
To deploy your  Web site (images and HTML files) to an Nginx web server using Ansible on CentOS 7, you can create a playbook with the following tasks:

- 1- Install Nginx:

```yaml
- name: Deploy Simple Web Application
  hosts: web
  become: true
  vars:
    nginx_conf_template: /home/vagrant/deploy-simple-website/templates/nginx.conf.j2
    website_files_directory: /home/vagrant/deploy-simple-website/files/
    server_name: 192.168.56.2

  tasks:
    - name: Install Nginx
      yum:
	name: nginx
        state: present

 ```       
- 2-Copy image and HTML files:
```yaml
- name: Copy Nginx configuration file
      template:
        src: "{{ nginx_conf_template }}"
        dest: /etc/nginx/nginx.conf
        owner: root
        group: root
        mode: 0644
      notify: Restart nginx

    - name: Copy website files
      synchronize:
        src: "{{ website_files_directory }}"
        dest: /usr/share/nginx/html
        delete: yes

    - name: Start Nginx service
      service:
	name: nginx
        state: started
        enabled: yes

  handlers:
    - name: Restart nginx
      service:
	name: nginx
        state: restarted

```

Ensure that you have the appropriate permissions to write to the destination directory /usr/share/nginx/html on the target web server.

To run the playbook, save it as a YAML file (e.g., deploy_web.yaml), and execute the following command:
```bash
ansible-playbook deploy_web.yaml
```

Make sure to replace **web** with the appropriate hostname or group name defined in your inventory file.

This playbook will install Nginx on the VM called web and copy your  HTML files to the appropriate location where Nginx serves its content. After executing the playbook, you should be able to access HTML files through the Nginx web server.