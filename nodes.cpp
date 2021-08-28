// nodes.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
using namespace std;

class node {

    
public:
    string data;
    node* next;

    //string operator+(string add1,string add2) {
    //     
    //}
    void setData(string dataIn) {
        data = dataIn;
    }
    node(string value) {
        data = value;
        next;
    }
    string getLast() {
        return data;
    }

    
    void addNodes(string text) {
        next = new node(text);
        }
};

class linkList {
    node* tail;
    node* head;
    int len = 0;
public:
    linkList(string value) {
        head = new node(value);
        tail = head;
        len++;
    }
    void addNode(string value) {
        //if (len < 2) {
        //    head->next = tail;
        //}
        tail->next = new node(value);
        tail = tail->next;
        len++;
    }

    string getIndex(int index) {
        node* result = head;
        for (size_t i = 0; i < index; i++)
        {
            result = result->next;
        }
        return result->data;
    }
    string getTail() {
        return tail->getLast();
    }


};

int main()
{
    linkList* list = new linkList("0");
    //std::cout<< list->getTail();
    list->addNode("1");
    //std::cout << list->getTail();
    list->addNode("kini mini sinein dfjfibf");
    list->addNode("3");
    list->addNode("4");
    std::cout << list->getIndex(2);

}
