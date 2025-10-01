FROM jetpackio/devbox-root-user:0.16.0

WORKDIR /code
RUN mkdir -p /code && chown root:root /code

USER root:root
COPY --chown=root:root devbox.json devbox.json
COPY --chown=root:root devbox.lock devbox.lock

RUN devbox run -- echo "Installed Packages." && nix-store --gc && nix-store --optimise

RUN devbox shellenv --init-hook >> ~/.profile
