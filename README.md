```
oc new-project demo

oc adm policy add-role-to-user admin system:serviceaccount:openshift-gitops:openshift-gitops-argocd-application-controller -n demo

oc apply -f gitops/configure.yaml

oc patch configs.imageregistry.operator.openshift.io/cluster --patch '{"spec":{"defaultRoute":true}}' --type=merge

HOST=$(oc get route default-route -n openshift-image-registry --template='{{ .spec.host }}')

podman login --tls-verify=false -u kubeadmin -p $(oc whoami -t) $HOST

cd services/service1

podman login -u='<USRN>' -p=<PSWD> registry.redhat.io

buildah build -t $HOST/demo/service1:latest .

buildah push --tls-verify=false $HOST/demo/service1:latest



curl -H 'Content-Type: application/json' -v http://demo-api-525eca1d5089dbdc-istio-system.apps.ocp.sandbox150.opentlc.com/api/
```
