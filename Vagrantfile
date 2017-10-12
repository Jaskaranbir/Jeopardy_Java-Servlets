# -*- mode: ruby -*-
# vi: set ft=ruby :

plugin_dependencies = [
  "vagrant-docker-compose",
  "vagrant-vbguest"
]

needsRestart = false

# Install plugins if required
plugin_dependencies.each do |plugin_name|
  unless Vagrant.has_plugin? plugin_name
    system("vagrant plugin install #{plugin_name}")
    needsRestart = true
    puts "#{plugin_name} installed"
  end
end

# Restart vagrant if new plugins were installed
if needsRestart === true
  exec "vagrant #{ARGV.join(' ')}"
end

Vagrant.configure(2) do |config|
  config.vm.define "jeopardyvm" do |jeopardyvm|
    jeopardyvm.vm.hostname = "codetalk"
    jeopardyvm.vm.box = "bento/ubuntu-16.04"
    jeopardyvm.vm.network "forwarded_port", guest: 8080, host: 8181, auto_correct: true

    jeopardyvm.vm.provider "virtualbox" do |vb|
      vb.name = "jeopardyvm"
      vb.gui = false
      vb.memory = "2048"
      vb.cpus = 2
    end

    # Run as non-login shell, sourcing it to /etc/profile instead of /root/.profile
    # Due to clashing configurations for vagrant and base box.
    # See: https://github.com/mitchellh/vagrant/issues/1673#issuecomment-28288042
    jeopardyvm.ssh.shell = "bash -c 'BASH_ENV=/etc/profile exec bash'"

    jeopardyvm.vm.provision "shell", inline: "apt-get update"
    jeopardyvm.vm.provision "docker"
    jeopardyvm.vm.provision :docker
    jeopardyvm.vm.provision :docker_compose, compose_version: "1.15.0", project_name: "Jeopardy", yml: ["/vagrant/docker-compose.yml"], rebuild: true, run: "always"
    jeopardyvm.vm.provision "shell", path: "scripts/deploy_wait_message.sh", run: "always", privileged: false
  end
end
