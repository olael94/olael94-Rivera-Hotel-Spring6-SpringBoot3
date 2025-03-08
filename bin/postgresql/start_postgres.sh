#!/usr/bin/env bash

set -euo pipefail

# Load the environment variables using a relative path to EnvVariables.env
ENV_FILE="$(dirname "$0")/../../EnvVariables.env"

# if the file exists, load the environment variables
if [ -f "$ENV_FILE" ]; then
    # shellcheck disable=SC2046
    export $(grep -v '^#' "$ENV_FILE" | xargs)
else
    echo "Error: EnvVariables.env file not found!"
    exit 1
fi

mkdir -p "$HOME"/.local/docker/postgresql

docker run --rm --name pg-docker -e POSTGRES_PASSWORD="${JDBC_DATABASE_PASSWORD}" -e POSTGRES_DB=local -d -p 5432:5432 -e PGDATA=/var/lib/postgresql/data/pgdata -v "$HOME"/.local/docker/postgresql/data:/var/lib/postgresql/data postgres
