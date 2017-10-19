Description
-----------------

A simple jeopardy game developed as part of my college project using java servlets and JSP (not my favorite stack).

**Note:** This game was developed under tight time-constraints and hence isn't mobile responsive. Minimum recommended viewing resolution is `1222x925`.

### Live Demo

The game is deployed on free subscription (as Web App) on Azure. Hence the resources available are very limited. It might take a few seconds for the application webpage to load initially since the VM goes to "suspend" mode after a while of inactivity, and has to be started again.

Additionally, daily CPU time is limited to 60 minutes. [*Here*][1] are more details regarding free limitations and other variants.

Finally, [**here**][2] is the live demo!

-----------------

[![Splash Menu][3]][3]

[![Game-Board][4]][4]

[![Game-Board][5]][5]

-----------------

Current Status
-----------------

Requires code structural optimization.

-----------------

**TODO:**

[ ] Replace Scriptlets with JSTL/EL

[ ] Organize file names for JSP files

[ ] Mobile responsiveness

-----------------

## Development Environment

Considering this as a college project, the aim was to make deployment easier (hence the implementation of React framework without Node.js). Further, being built using maven allows for easier dependency resolution.

There are two methods to setup the environment for running this game.

* **Using Docker**

**On Windows**

* Since Docker config used is based on linux containers, windows users will have to run it inside a VM. So, download and install [Vagrant][6] and [Virtualbox][7].

* Go to project directory and run `vagrant up` in terminal.

* This will setup Vagrant and docker containers and deploy application on address `http://localhost:<PORT>/jeopardy` (where `<PORT>` corresponds to a valid open port chosen by Vagrant).

* *You will get the exact web-address which you can enter in your browser to run the game (once the script finishes successfully)*.

* If for some reason, docker containers do not build, you can ssh into VM using `vagrant ssh` and then use the command `docker rm $(docker ps -aq) && docker-compose up -d` to try building again.

**On Linux**

* Download and install docker and docker-compose.

* Go to project directory and run `docker-compose up -d`.

* Ensure port `8080` is free or the containers won't run (unless configured to specifically use another port). Application will be deployed on address `http://localhost:8080/jeopardy`.

**NOTE**: You can also setup Vagrant in Linux and use the same procedure as provided for Windows.

This setup is recommended if you intend to just test and play around with the game. This will **entirely** rebuild the project everytime the images are built (including downloading Maven dependencies). Hence manual setup (provided below) is recommended for manual development.

* **Running manually without Docker**

* To setup environment, simply clone this repository and open the project in your preferred IDE with integration of your preferred web container (Apache Tomcat 8.5 was used for initial development).

* Install Maven dependencies and run the project (IDEs usually do this for you).

This setup is recommended if you want to develop on this game.

**Side Note:** Vagrant connects with a website to get a random string to prevent Docker from caching builds (otherwise source code changes will not be recognized by Docker). If you get an error that says something like `request timedout`, and you are positive that your internet is working fine, then try restarting vagrant (`vagrant reload`) or try restarting your computer.

  [1]: https://blog.siliconvalve.com/2016/05/12/understanding-azure-app-service-plans-and-pricing/
  [2]: http://jas-java-proj-1.azurewebsites.net/jeopardy/
  [3]: https://imgur.com/yWZA4DB.jpg
  [4]: https://i.imgur.com/hgVpVlD.png
  [5]: https://i.imgur.com/edz45Zi.png
  [6]: https://www.vagrantup.com/
  [7]: https://www.virtualbox.org/