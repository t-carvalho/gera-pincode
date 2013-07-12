#include <iostream>
#include <algorithm>
#include <utility> 
#include <set>

using namespace std;

int main ()
{
    set<string> unicos;
    char chars[20]  = {'2', '3', '7', '9', 'C', 'D', 'E', 'F', 'H', 'J', 'K', 'M', 'N', 'P', 'Q', 'R', 'T', 'X', 'Y', 'Z'};
    int  atual[9]  = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    int  incrementa = 0;

    long unsigned int gerar   = 22e6;
    long unsigned int gerados = 0;

    while (gerados < gerar) {
        string item;    
        item = "K";
        item += chars[atual[0]];
        item += chars[atual[1]];
        item += chars[atual[2]];
        item += chars[atual[3]];
        item += chars[atual[4]];
        item += chars[atual[5]];
        item += chars[atual[6]];
        item += chars[atual[7]];
        item += chars[atual[8]];
        
        if (!unicos.insert(item).second) {
            //cout << "duplicado" << endl;    
        } else {
            cout << item << endl;
            gerados++;
        }

        
        atual[incrementa] += rand();
        atual[incrementa] = atual[incrementa] % 20;

        incrementa += rand();
        incrementa = incrementa % 9;
    }

    return 0;
}