docker run --name mitl -it -d  claudiomenghi/mitl /bin/bash 
docker cp ./prova.mitli mitl:/workspace/
docker exec mitl java -jar tack.jar ./prova.mitli 10
