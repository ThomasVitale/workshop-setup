#!/bin/sh

set -euo pipefail

echo "\n📦 Initializing Kubernetes cluster..."

kind create cluster --config kind-config.yml

echo "\n🔌 Installing Contour Ingress..."

kubectl apply -f https://projectcontour.io/quickstart/contour.yaml 

sleep 10

kubectl wait --namespace projectcontour \
  --for=condition=ready pod \
  --selector=app=contour \
  --timeout=60s

kubectl wait --namespace projectcontour \
  --for=condition=ready pod \
  --selector=app=envoy \
  --timeout=60s

kind delete cluster --name workshop-cluster

echo "\n⛵ Testing completed successfully!\n"
