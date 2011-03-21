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
           | function SEMICOLON functions  { sprintf(line,"%s%s",$1,$3); $$ = strdup(line); }

function: FUNCTION OPEN NUMBER CLOSE {  /* printf("Seeing %s\n",$1); */ sprintf(line,"%s\t%d\n",$1,$3); $$= strdup(line); }
        
