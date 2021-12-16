package com.granson.seniordeveloper.di

import android.content.Context
import com.granson.seniordeveloper.R
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Named
import javax.inject.Qualifier

@Module
@InstallIn(ActivityComponent::class)
object StarterModule {

    @Provides
    @ActivityScoped
    @AScoped
    fun provideActivityString(
        @ApplicationContext context: Context
    ): String = context.getString(R.string.bound)

    @Provides
    @ActivityScoped
    fun provideFragString(
        @ApplicationContext context: Context
    ): String = context.getString(R.string.bound)

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class AScoped
}