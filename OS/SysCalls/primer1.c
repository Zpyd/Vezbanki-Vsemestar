#include <stdio.h>
#include <string.h>
#include <sys/file.h>
#include <sys/syscall.h>
#include <unistd.h>
#include <fcntl.h>
#include <errno.h>
#include <sys/stat.h>

#define size 1024

int main(int argc, char* argv[]){


char* Kopira=argv[1];

mode_t rezim = (S_IRWXU | S_IRWXG | S_IRWXO);
int fd= open(Kopira,O_RDONLY,NULL);

if(fd==-1){
    printf("shefe ne se otvori datotekata za citanje");
    exit (1);
}

int fdesc[argc-2];
for (int i = 0; i < argc-2; i++)
{
    fdesc[i]=open(argv[2+i],O_CREAT|O_RDWR,rezim);
    if(fdesc[i]==-1){
        printf("nemoze da se otvore datotekata %s", argv[2+i]);
    }
    char buffer[size];
    ssize_t bytes_read;
    while((bytes_read= read(fd,buffer,size))>0){
        write(fdesc[i],buffer,bytes_read);
    }

}


for (int i = 0; i < argc-2; i++)
{
    close(fdesc[i]);
    
}

close(fd);
return 0;
}
