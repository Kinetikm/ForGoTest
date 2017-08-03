from argparse import ArgumentParser
import sys
import os


def main():

    size_for_ram = 1024*1024

    parser = ArgumentParser()
    parser.add_argument('-f', '--file_count', type=str, default=None, help='Filename for string count')
    args = parser.parse_args()

    if args.file_count is None:
        sys.stdout.write("File hasn't been specified\n")
    else:
        try:
            if os.path.getsize(args.file_count) <= size_for_ram:
                with open(args.file_count, 'r') as file:
                    sys.stdout.write("String number in file: {}\n".format(len(file.readlines())))
            else:
                counter = 0
                with open(args.file_count, 'r') as file:
                    for _ in file:
                        counter += 1
                sys.stdout.write("String number in file: {}\n".format(counter))
        except FileNotFoundError as ex:
            sys.stdout.write("File not found\n")


if __name__ == '__main__':
    main()