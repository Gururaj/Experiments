pyTriplets n = [(a,b,c) | (a,b,c)<-[(a,b,c)| c<-[1..n], b<-[1..n], a<-[1..n]], a*a+b*b==c*c]