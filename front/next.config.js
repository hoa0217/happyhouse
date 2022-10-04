process.env.KAKAO_API_KEY = '51b2609483f18c181b76031c296f8316';

/** @type {import('next').NextConfig} */
const nextConfig = {
  // reactStrictMode: true,
  swcMinify: true,
  // images 추후에 지워야함
  images: {
    domains: ['dimg.donga.com'],
  },
  // images 추후에 지워야함
  async redirects() {
    return [
      {
        source: '/',
        destination: '/apart',
        permanent: true,
      },
    ];
  },
};

module.exports = nextConfig;
