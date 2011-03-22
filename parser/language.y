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

char line[1024];
int rownum =0;
char rownumstr[10];

%}

%token OPEN CLOSE SEMICOLON COMMA

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

start: functions {printf("%s",line); }

functions: function SEMICOLON
                    {
                        //$$ = $1
                    }
           | function SEMICOLON functions
                                 {
                                        //sprintf(line,"%s\n%s\n",line,$1);
                                        //$$ = strdup(line);
                                 }

function:
        FUNCTION OPEN function CLOSE
                                {       /* To be added for functions within functions */
                                        sprintf(line,"%s%d\t%s\t[%s]\n",line,rownum,$1,$3);
                                        sprintf(rownumstr,"%d",rownum);
                                        $$= strdup(rownumstr);
                                        rownum++;
                                }
        | FUNCTION OPEN function COMMA NUMBER CLOSE
                                {       /* To be added for functions within functions */
                                        sprintf(line,"%s%d\t%s\t[%s]\t%d\n",line,rownum,$1,$3,$5);
                                        sprintf(rownumstr,"%d",rownum);
                                        $$= strdup(rownumstr);
                                        rownum++;
                                }
        | FUNCTION OPEN function COMMA function CLOSE
                                {       /* To be added for functions within functions */
                                        sprintf(line,"%s%d\t%s\t[%s]\t[%s]\n",line,rownum,$1,$3,$5);
                                        sprintf(rownumstr,"%d",rownum);
                                        $$= strdup(rownumstr);
                                        rownum++;
                                }                                
        | FUNCTION OPEN NUMBER COMMA function CLOSE
                                {       /* To be added for functions within functions */
                                        sprintf(line,"%s%d\t%s\t%d\t[%s]\n",line,rownum,$1,$3,$5);
                                        sprintf(rownumstr,"%d",rownum);
                                        $$= strdup(rownumstr);
                                        rownum++;
                                }                                
        | FUNCTION OPEN NUMBER CLOSE
                                {        /* printf("Seeing %s\n",$1); */
                                        sprintf(line,"%s%d\t%s\t%d\n",line,rownum,$1,$3);
                                        sprintf(rownumstr,"%d",rownum);
                                        $$= strdup(rownumstr);
                                        rownum++;
                                }
        | FUNCTION OPEN NUMBER COMMA NUMBER CLOSE
                                {        /* printf("Seeing %s\n",$1); */
                                        sprintf(line,"%s%d\t%s\t%d\t%d\n",line,rownum,$1,$3,$5);
                                        sprintf(rownumstr,"%d",rownum);
                                        $$= strdup(rownumstr);
                                        rownum++;
                                }
                                