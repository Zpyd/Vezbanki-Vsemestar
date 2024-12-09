int main(int argc,char *argv[]){
    
    //voa e zadacata ama treba da se napravat dopolnitelnite proverki dale se uklucila or whatever
    
    pid_t dete[2];
    for(int i=0;i<2;i++)
    {
        dete[i]=fork();
        if(dete[i]==0) break;
    }
    int fd=open("ekran data", O_WROLY | O_CREATE | O_APPEND ,rezim);//rezim e taj so stalno go koristeme 
    dup2(fd,1);
    execvp(argv[1],&argv[1]); 

}