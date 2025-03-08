#!/usr/bin/env bash

set -euo pipefail

# Load the environment variables
ENV_FILE="/Users/orivera/Desktop/Desktop/ENSIGN/4th Semester/CS 460 Advanced Software Engineering/Week 1/rivera-hotel/EnvVariables.env"

if [ -f "$ENV_FILE" ]; then
    # shellcheck disable=SC2046
    export $(grep -v '^#' "$ENV_FILE" | xargs)
else
    echo "Error: EnvVariables.env file not found!"
    exit 1
fi

mkdir -p "$HOME"/.local/docker/postgresql

docker run --rm --name pg-docker -e POSTGRES_PASSWORD="${JDBC_DATABASE_PASSWORD}" -e POSTGRES_DB=local -d -p 5432:5432 -e PGDATA=/var/lib/postgresql/data/pgdata -v "$HOME"/.local/docker/postgresql/data:/var/lib/postgresql/data postgres
