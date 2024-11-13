cmake_minimum_required(VERSION 3.29)
project(Nitki C)

set(CMAKE_C_STANDARD 11 -pthread)

add_executable(Nitki main.c)

target_link_libraries(Nitki pthread)