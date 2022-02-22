ADD file:c51141702f568a28a7e3e7a2748f5ead5754e32d7b1cf7ebc8f4326273d05206 in /
CMD ["bash"]
RUN groupadd -r mysql
   &&  useradd -r -g mysql mysql
RUN apt-get update
   &&  apt-get install -y --no-install-recommends gnupg dirmngr
   &&  rm -rf /var/lib/apt/lists/*
ENV GOSU_VERSION=1.14
RUN set -eux; savedAptMark="$(apt-mark showmanual)"; apt-get update; apt-get install -y --no-install-recommends ca-certificates wget; rm -rf /var/lib/apt/lists/*; dpkgArch="$(dpkg --print-architecture | awk -F- '{ print $NF }')"; wget -O /usr/local/bin/gosu "https://github.com/tianon/gosu/releases/download/$GOSU_VERSION/gosu-$dpkgArch"; wget -O /usr/local/bin/gosu.asc "https://github.com/tianon/gosu/releases/download/$GOSU_VERSION/gosu-$dpkgArch.asc"; export GNUPGHOME="$(mktemp -d)"; gpg --batch --keyserver hkps://keys.openpgp.org --recv-keys B42F6819007F00F88E364FD4036A9C25BF357DD4; gpg --batch --verify /usr/local/bin/gosu.asc /usr/local/bin/gosu; gpgconf --kill all; rm -rf "$GNUPGHOME" /usr/local/bin/gosu.asc; apt-mark auto '.*' > /dev/null; [ -z "$savedAptMark" ] || apt-mark manual $savedAptMark > /dev/null; apt-get purge -y --auto-remove -o APT::AutoRemove::RecommendsImportant=false; chmod +x /usr/local/bin/gosu; gosu --version; gosu nobody true
RUN mkdir /docker-entrypoint-initdb.d
RUN apt-get update
   &&  apt-get install -y --no-install-recommends pwgen openssl perl xz-utils
   &&  rm -rf /var/lib/apt/lists/*
RUN set -ex; key='859BE8D7C586F538430B19C2467B942D3A79BD29'; export GNUPGHOME="$(mktemp -d)"; gpg --batch --keyserver keyserver.ubuntu.com --recv-keys "$key"; gpg --batch --export "$key" > /etc/apt/trusted.gpg.d/mysql.gpg; gpgconf --kill all; rm -rf "$GNUPGHOME"; apt-key list > /dev/null
ENV MYSQL_MAJOR=8.0
ENV MYSQL_VERSION=8.0.28-1debian10
RUN echo 'deb http://repo.mysql.com/apt/debian/ buster mysql-8.0' > /etc/apt/sources.list.d/mysql.list
RUN { echo mysql-community-server mysql-community-server/data-dir select ''; echo mysql-community-server mysql-community-server/root-pass password ''; echo mysql-community-server mysql-community-server/re-root-pass password ''; echo mysql-community-server mysql-community-server/remove-test-db select false; } | debconf-set-selections
   &&  apt-get update
   &&  apt-get install -y mysql-community-client="${MYSQL_VERSION}" mysql-community-server-core="${MYSQL_VERSION}"
   &&  rm -rf /var/lib/apt/lists/*
   &&  rm -rf /var/lib/mysql
   &&  mkdir -p /var/lib/mysql /var/run/mysqld
   &&  chown -R mysql:mysql /var/lib/mysql /var/run/mysqld
   &&  chmod 1777 /var/run/mysqld /var/lib/mysql
VOLUME [/var/lib/mysql]
COPY dir:2e040acc386ebd23b8571951a51e6cb93647df091bc26159b8c757ef82b3fcda in /etc/mysql/
COPY file:c112ec3a02a7b818421f8613e69e548ad2ee644304066708204abb684d77664a in /usr/local/bin/
RUN ln -s usr/local/bin/docker-entrypoint.sh /entrypoint.sh # backwards compat
ENTRYPOINT ["docker-entrypoint.sh"]
EXPOSE 3306 33060
CMD ["mysqld"]