package com.naruto.di

import com.naruto.repository.HeroRepository
import com.naruto.repository.HeroRepositoryImpl
import org.koin.dsl.module

val koinModule = module { single<HeroRepository> { HeroRepositoryImpl() } }
