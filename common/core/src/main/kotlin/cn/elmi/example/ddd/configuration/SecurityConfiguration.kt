package cn.elmi.example.ddd.configuration

import io.micronaut.context.annotation.Bean
import io.micronaut.context.annotation.Factory
import io.micronaut.http.HttpRequest
import io.micronaut.security.authentication.*
import io.micronaut.security.token.jwt.signature.rsa.RSASignatureGenerator
import io.micronaut.security.token.jwt.signature.rsa.RSASignatureGeneratorConfiguration
import io.reactivex.Maybe
import org.reactivestreams.Publisher
import javax.inject.Named
import javax.inject.Singleton

class SecurityConfiguration

@Singleton
class AuthenticationProviderUserPassword : AuthenticationProvider {
    override fun authenticate(httpRequest: HttpRequest<*>?, authenticationRequest: AuthenticationRequest<*, *>): Publisher<AuthenticationResponse> {

        // TODO replace project.reactor
        return Maybe.create<AuthenticationResponse> {
            if (authenticationRequest.identity == "user" && authenticationRequest.secret == "password") it.onSuccess(UserDetails("user", ArrayList()))
            else it.onSuccess(AuthenticationFailed())
        }.toFlowable()
    }
}

@Factory
class MySignatureGeneratorConfigurationFactory {
    @Bean
    @Named("generator")
    fun signatureGeneratorConfiguration(configuration: RSASignatureGeneratorConfiguration) = RSASignatureGenerator(configuration)
}

//class CustomAuthenticationProvider : AuthenticationProvider {
//    override fun authenticate(
//        httpRequest: HttpRequest<*>?,
//        authenticationRequest: AuthenticationRequest<*, *>?
//    ): Publisher<AuthenticationResponse> {
//
//    }
//}