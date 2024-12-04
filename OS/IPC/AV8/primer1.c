#include <sys/ipc.h>
#include <sys/shm.h>
#include <sys/wait.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>

/*
Да се напишат програми кои ќе комуницираат помеѓу себе користејќи
заедничка меморија.
Првата програма (процес) треба да запише во заедничката меморија првиот
аргумент од командна линија.
Втората програма треба да го прочита тоа што е запишано во заедничката
меморија и испише на екран.

*/


//mojta e pisuvana so fork ama bukv se mislilo od druga datoteka da se accesne istoto


int main (int argc,char* argv[]){

    if(argc<2){
        printf("Nedoveln broj na argumenti");
        return 1;
    }

    //moze i key_t kluc so bilo koja vrednost za key da staveme mesto IPC_PRIVATE  
    int shmid=shmget(IPC_PRIVATE,sizeof(int),IPC_CREAT|IPC_EXCL|0666);
    if(shmid==-1){
        perror("shmget");
        exit(1);
    }


     int *shm_Adress= (int*)shmat(shmid,NULL,0);


        if(shm_Adress==(int*)-1){ //zaso treba da se kastira -1????
            perror("shmat failed");
            exit(1);
        }

        *shm_Adress=argv[1];


        if(shmdt(shm_Adress)==-1){
            perror("shmdt");
            exit(1);
        }
    

    pid_t cid=fork();
    if(cid==0){
        int *shm_Adress= (int*)shmat(shmid,NULL,0);


        if(shm_Adress==(int*)-1){
            perror("shmat failed");
            exit(1);
        }

        printf("ja sum vtorio proces i argumento od komandna linija e: %d", *shm_Adress);

        if(shmdt(shm_Adress)==-1){
            perror("shmdt");
            exit(1);
        }
    }

    
    if(cid>0){

        wait(NULL);
        //when do you dealocate it?

        shmctl(shmid,IPC_RMID,0);
    }

    
}

