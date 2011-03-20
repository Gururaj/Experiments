%{

#include <stdio.h>
#include <string.h>

void yyerror(const char *str) {
  fprintf(stderr,"Error: %s\n",str);
}

int yywrap() {
  return 1;
}

void main() {
  yyparse();
}

%}

%token NUMBER FUNCTION OPEN CLOSE

%%

start: FUNCTION OPEN NUMBER CLOSE { printf("A function was called\n"); }
        
