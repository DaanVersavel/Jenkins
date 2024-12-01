def repo;
def branch;


pipeline {
    agent {
        label "built-in";
    }

    stages {
        stage ("Set configuration") {
            steps {
                script{
                    repo = env.repo;
                    branch = env.branch;
                }
            }
        }

        stage("Get Globis source code from GIT") {
            steps{
                script{
                  steps {
                        echo "Cloning the repository from ${repo} on branch ${branch}..."
                        git branch: "${branch}", url: "${repo}"
                    }
                }
            }
        }
    }
}