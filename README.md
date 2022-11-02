```
oc new-project demo

oc adm policy add-role-to-user admin system:serviceaccount:openshift-gitops:openshift-gitops-argocd-application-controller -n demo

oc apply -f gitops/configure.yaml

```
