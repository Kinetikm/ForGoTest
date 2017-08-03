package main

import (
	"fmt"
	"flag"
	"os"
	"bufio"
)

func main() {
	var counter = 0
	var filePathPtr string

	flag.StringVar(&filePathPtr, "f", "", "a string")
	flag.Parse()

	if filePathPtr == ""{
		fmt.Print("Please definit the file")
		return
	}

	fmt.Print(filePathPtr)
	file, err := os.Open(filePathPtr)

	if err != nil {
		fmt.Print("File not found\n")
		return
	}

	f := bufio.NewScanner(file)
	for f.Scan(){
		counter+=1
	}
	defer file.Close()
	fmt.Print("step3\n")

	fmt.Print("Number of strings: ", counter, "\n")
}
