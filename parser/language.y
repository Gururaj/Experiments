%{

#include <stdio.h>
#include <string.h>

void yyerror(const char *str) {
  fprintf(stderr,"Error: %s\n",str);
}

int yywrap() {
  return 1;
}

int main() {
  yyparse();
  return 0;
}

char line[100];
int rownum =0;

%}

%token OPEN CLOSE SEMICOLON

%type <string> function
%type <string> functions
%type <string> start

%union
{
        int number;
        char *string;
}

%token <number> NUMBER
%token <string> FUNCTION

%%

start: functions {printf("%s",$$); }

functions: function SEMICOLON { $$ = $1 }
           | function SEMICOLON functions
                                 {
                                        sprintf(line,"%s%s",$1,$3);
                                        $$ = strdup(line);
                                 }

function:
        FUNCTION OPEN FUNCTION CLOSE { /* To be added for functions within functions */ }
        | FUNCTION OPEN NUMBER CLOSE
                                {        /* printf("Seeing %s\n",$1); */
                                        sprintf(line,"%d\t%s\t%d\n",rownum,$1,$3);
                                        $$= strdup(line);
                                        rownum++;
                                }
        
