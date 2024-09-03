#!/bin/bash
# Script to set up Git hooks

echo "Setting up Git hooks..."

# Ensure the hooks directory exists
mkdir -p .git/hooks

# Copy the pre-commit hook into the .git/hooks directory
cp .githooks/pre-commit .git/hooks/pre-commit

# Make the pre-commit hook executable
chmod +x .git/hooks/pre-commit

echo "Git hooks are set up."
