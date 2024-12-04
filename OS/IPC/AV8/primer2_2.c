#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <unistd.h>
#include <sys/mman.h>
#include <fcntl.h>


/*

Да се напишат програми кои ќе комуницираат помеѓу себе користејќи
мемориско мапирање.
Едната програма треба да ги смести сите парни броеви од 1 до 2000.
Другата програма треба да ги прочита и испише на екран овие броеви.
Да се овозможи механизам да втората програма ја повика првата
програма и почека додека заврши пред да пристапи до мапираната
меморија.

*/


//e vaa trebalo dase prae u 1 a ja u 2 programi se zatrca da ja napraam 

int main(int argc,char*argv[]){


    int fd=open(argv[1], O_RDWR | O_CREAT,00666); //namesto staticno 4k moze 1000*sizeof(int) da staeme kako 2r argument na mmap
    if(fd==-1){
        printf("neuspesno otvoranje na datotekata bud");

    }

    int* addresa= (int*) mmap(NULL,1000*(sizeof(int)),PROT_READ|PROT_WRITE,MAP_SHARED,fd,0);
    if(addresa== MAP_FAILED){
        printf("ne se mapira od memorijata");
    }
    for (int i = 1; i <= 1000; i++)
    {

        printf("%d\t",addresa[i]);
            
    }
    
    munmup(addresa,1000*(sizeof(int))); 

}