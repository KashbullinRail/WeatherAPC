package com.example.weatherapc.base

import com.example.weatherapc.base.Either.*

inline fun <reified T> attempt(func: () -> T): Either<Throwable, T> = try {
    Right(func.invoke())
} catch (e: Throwable) {
    Left(e)
}