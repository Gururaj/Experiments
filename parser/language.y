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
char rownumstr[128];

%}

%union
{
        int number;
        char *string;
}


%token OPEN CLOSE SEMICOLON COMMA 


%token <number> NUMBER
%token <string> FLOAT
%token <string> OPERATOR FUNCTION


%type <string> function expression
%type <string> functions
%type <string> start


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
        NUMBER                  {
                                        //sprintf(line,"%s%d\tNUM\t%d\n",line,rownum,$1);
                                        //sprintf(rownumstr,"%d",rownum);
                                        //$$ = strdup(rownumstr);
                                        //rownum++;
                                        sprintf(rownumstr,"int(%d)",$1);
                                        $$ = strdup(rownumstr);
                                }
        | FLOAT                  {
                                        //sprintf(line,"%s%d\tNUM\t%d\n",line,rownum,$1);
                                        //sprintf(rownumstr,"%d",rownum);
                                        //$$ = strdup(rownumstr);
                                        //rownum++;
                                        sprintf(rownumstr,"float(%s)",$1);
                                        $$ = strdup(rownumstr);
                                }                                
        | expression
                                {       /* To be added for functions within functions */
                                        //sprintf(line,"%s%d\t%s\n",line,rownum,$1);
                                        //sprintf(rownumstr,"%d",rownum);
                                        //$$= strdup(rownumstr);
                                        //rownum++;
                                        $$ = $1;
                                }
        | OPEN expression CLOSE
                                {       /* To be added for functions within functions */
                                        //sprintf(line,"%s%d\t%s\n",line,rownum,$2);
                                        //sprintf(rownumstr,"%d",rownum);
                                        //$$= strdup(rownumstr);
                                        //rownum++;
                                        $$ = $2;
                                }                                        
        | FUNCTION OPEN function CLOSE
                                {       /* To be added for functions within functions */
                                        sprintf(line,"%s%d\t%s\t%s\n",line,rownum,$1,$3);
                                        sprintf(rownumstr,"%d",rownum);
                                        $$= strdup(rownumstr);
                                        rownum++;
                                }
        | FUNCTION OPEN function COMMA function CLOSE
                                {       /* To be added for functions within functions */
                                        sprintf(line,"%s%d\t%s\t%s\t%s\n",line,rownum,$1,$3,$5);
                                        sprintf(rownumstr,"%d",rownum);
                                        $$= strdup(rownumstr);
                                        rownum++;
                                }

expression:
        function OPERATOR function
                                {
                                        sprintf(line,"%s%d\t%s\t%s\t%s\n",line,rownum,$2,$1,$3);
                                        sprintf(rownumstr,"%d",rownum);
                                        $$= strdup(rownumstr);
                                        rownum++;                          
                                }